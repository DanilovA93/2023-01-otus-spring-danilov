package ru.otus.spring.quiz.interractor;

public interface Interactor {

  void askUserToQuitOrRestart(Runnable quitAction, Runnable restartAction);
}
