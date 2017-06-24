package model;

import constants.GamePoints;
import interfaces.PlayerInterface;

/**
 * Created by avishai on 6/24/2017.
 */

public class Player implements PlayerInterface {

    private Boolean matchWinner = false;

    private int wonSets = 0;
    private int wonGames = 0;
    private int serveFouls = 0;

    private int pointIndex = 0;
    private String [] pointsArr = {"0", "15", "30", "40", "AD"};

    public Player() {
    }

    @Override
    public void addServeFoul(PlayerInterface opponent) {

        if (serveFouls == 1) {
            opponent.addGamePoint(this);
            serveFouls = 0;
        }
        else{
            serveFouls++;
        }
    }

    @Override
    public void addGamePoint(PlayerInterface opponent) {

        if(this.getPoints() == GamePoints.POINTS_40){

            if(opponent.getPoints() == GamePoints.POINTS_AD){
                 opponent.looseAdvantage();
            }
            else if(opponent.getPoints() == GamePoints.POINTS_40){
                pointIndex++;
            }
            else{
                this.winGame(opponent);
            }
        }
        else if(this.getPoints() == GamePoints.POINTS_AD){
            this.winGame(opponent);
        }
        else{
            pointIndex++;
        }
    }

    @Override
    public void winGame(PlayerInterface opponent) {
        pointIndex = 0;
        serveFouls = 0;

        wonGames++;
        opponent.resetGame();

        if(wonGames >= 6){

            if(opponent.getGames() == wonGames || opponent.getGames() == (wonGames - 1)){
                //game continues within current set.
            }
            else{
                winSet(opponent);
            }
        }
    }

    @Override
    public void winSet(PlayerInterface opponent) {
        //reset won games back to zero
        wonGames = 0;

        wonSets++;

        if(wonSets == 3){
            this.winMatch(); //whoohoo!!
        }
        else{
            opponent.resetSet();
        }
    }

    @Override
    public void winMatch() {
        matchWinner = true;
    }

    @Override
    public void reset() {
        serveFouls = 0;
        pointIndex = GamePoints.POINTS_ZERO;
        wonGames = 0;
        wonSets = 0;
        matchWinner = false;
    }

    @Override
    public void resetGame(){
        serveFouls = 0;
        pointIndex = GamePoints.POINTS_ZERO;
    }

    @Override
    public void resetSet(){
        resetGame();
        wonGames = 0;
    }

    @Override
    public int getPoints() {
        return pointIndex;
    }

    @Override
    public String getPointsString() {
        return pointsArr[pointIndex];
    }

    @Override
    public int getGames() {
        return wonGames;
    }

    @Override
    public void looseAdvantage() {
        if(pointIndex == GamePoints.POINTS_AD){
            pointIndex =  GamePoints.POINTS_40;
        }
    }

    public int getWonSets() {
        return wonSets;
    }

    public int getServeFouls() {
        return serveFouls;
    }

    public Boolean isWon(){
        return matchWinner;
    }
}
