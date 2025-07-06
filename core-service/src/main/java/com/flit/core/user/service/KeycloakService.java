package com.flit.core.user.service;

import com.flit.core.user.dto.view.TokensViewDto;
import com.flit.core.user.enums.Role;
import jakarta.ws.rs.core.Response;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeycloakService {

    @Value("${keycloak.realm}")
    private String realm;

    private final KeycloakBuilder keycloakClientBuilder;
    private final Keycloak keycloakAdminClient;

    public KeycloakService(KeycloakBuilder keycloakClientBuilder, Keycloak keycloakAdminClient) {
        this.keycloakClientBuilder = keycloakClientBuilder;
        this.keycloakAdminClient = keycloakAdminClient;
    }

    public TokensViewDto getTokens(String email, String password) {
        Keycloak keycloakClient = keycloakClientBuilder
                .username(email)
                .password(password)
                .build();

        AccessTokenResponse tokenResponse = keycloakClient.tokenManager().getAccessToken();

        return new TokensViewDto(
                tokenResponse.getToken(),
                tokenResponse.getRefreshToken()
        );
    }

    public String createUserInKc(String email, String password, Role role) {
        RealmResource realmResource = keycloakAdminClient.realm(realm);
        UsersResource usersResource = realmResource.users();

        var user = buildUserRepresentation(email, password);

        Response kcApiResponse = usersResource.create(user);

        String userId = CreatedResponseUtil.getCreatedId(kcApiResponse);

        RoleRepresentation roleRepresentation = getRoleRepresentation(role, realmResource);

        assignRoleToUser(userId, roleRepresentation, usersResource);

        return userId;
    }

    private UserRepresentation buildUserRepresentation(String email, String password) {
        var user = new UserRepresentation();

        user.setEmail(email);
        user.setEnabled(true);

        CredentialRepresentation credential = new CredentialRepresentation();

        credential.setValue(password);
        credential.setTemporary(false);
        credential.setType(CredentialRepresentation.PASSWORD);

        user.setCredentials(List.of(credential));

        return user;
    }

    private RoleRepresentation getRoleRepresentation(Role role, RealmResource realmResource) {
        String roleName = role.name();

        return realmResource
                .roles()
                .get(roleName)
                .toRepresentation();
    }

    private void assignRoleToUser(String userId, RoleRepresentation roleRepresentation, UsersResource usersResource) {
        usersResource
                .get(userId)
                .roles()
                .realmLevel()
                .add(List.of(roleRepresentation));
    }
}
