package builders;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.InputStreamReader;
import java.io.Reader;

public class LoginDataBuilder {
    private String username;
    private String password;

    public LoginDataBuilder fromJsonResource(String resourcePath, String sectionName) {
        try (Reader r = new InputStreamReader(getClass().getResourceAsStream(resourcePath))) {
            Gson g = new Gson();
            JsonObject root = g.fromJson(r, JsonObject.class);

            JsonObject section = root.getAsJsonObject(sectionName);

            this.username = section.get("username").getAsString();
            this.password = section.get("password").getAsString();

        } catch (Exception e) {
            throw new RuntimeException("Failed to read login data: " + e.getMessage(), e);
        }
        return this;
    }

    public LoginData build() {
        return new LoginData(username, password);
    }


    public static class LoginData {
        public final String username;
        public final String password;


        public LoginData(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }
}
