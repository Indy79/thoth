package fr.maif.eventsourcing.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "thoth.datasource")
public class DataSourceProperties {

    private String host;
    private int port;
    private String name;
    private CredentialProperties credential;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getName() {
        return name;
    }

    public CredentialProperties getCredential() {
        return credential;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredential(CredentialProperties credential) {
        this.credential = credential;
    }
}
