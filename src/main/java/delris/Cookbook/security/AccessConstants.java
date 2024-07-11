package delris.Cookbook.security;

public final class AccessConstants {
    public static final String permitAllRoles = "hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')";
    public static final String permitUser = "hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')";
    public static final String permitAdminAndModerator = "hasRole('ADMIN') or hasRole('MODERATOR')";
    public static final String permitAdmin = "hasRole('ADMIN')";
}
