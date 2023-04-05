package com.example.travelator;

public class EmailAddress {
    private final String localPart;
    private final String domain;

    public static EmailAddress parse(String address) {
        var at = address.indexOf('@');
        if (at == -1) {
            throw new IllegalArgumentException("Invalid email address: " + address);
        }
        return new EmailAddress(address.substring(0, at), address.substring(at + 1));
    }

    public EmailAddress(String localPart, String domain) {
        this.localPart = localPart;
        this.domain = domain;
    }

    public String getLocalPart() {
        return localPart;
    }

    public String getDomain() {
        return domain;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return localPart + "@" + domain;
    }
}
