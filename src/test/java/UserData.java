public enum UserData {
    FIRSTNAME("Ирина"),
    LASTNAME("Ушакова"),
    EMAIL("test@example.com"),
    MOBIlE("1234567890"),
    MONTHBIRTH("2"),
    YEARBIRTH("2000"),
    DAYBIRTH("014"),
    SUBJECT("Информатика"),
    ADDRESS("Самара"),
    STATE("Haryana"),
    CITY("Karnal");
    public final String value;
    private UserData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
