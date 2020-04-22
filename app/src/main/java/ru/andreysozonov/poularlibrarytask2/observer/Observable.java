package ru.andreysozonov.poularlibrarytask2.observer;

public interface Observable {

    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyAllObservers(int number, String thread);
}
