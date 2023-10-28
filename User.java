public abstract class User {
    protected String fullName; // ФИО
    protected long UIN; // Unique Identification Number = ИИН
    protected String phoneNumber; // e.g. 7-707-543-44-32

    public abstract void changePhoneNumber(String newPhoneNumber);

    public abstract void changeFullName(String newFullName);
}
