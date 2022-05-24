package dev.ogabek.java.manager;

public interface AuthHandler {

    public void onSuccess();
    void onError(Exception exception);

}
