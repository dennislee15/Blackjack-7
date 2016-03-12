/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import models.Game;
import models.playerGame;
import ninja.Result;
import ninja.Results;
import ninja.Context;
import models.dealerGame;
import com.google.inject.Singleton;
import ninja.params.PathParam;


@Singleton
public class ApplicationController {

    public Result index() {

        return Results.html();

    }

    public Result blackjack(){

        return Results.html().template("views/Blackjack/Blackjack.flt.html");
    }

    public Result playerGameGet(){
        playerGame g = new playerGame();
        g.buildDeck();
        g.shuffle();
        g.initialDeal();
        return Results.json().render(g);
    }

    public Result dealerGameGet(){
        dealerGame g = new dealerGame();
        g.buildDeck();
        g.shuffle();
        g.initialDeal();
        return Results.json().render(g);
    }

    public Result playerHit(Context context, @PathParam("columnTo") int col, playerGame g) {
        if(context.getRequestPath().contains("player")){
            g.hit(col);
        }
        return Results.json().render(g);
    }

    public Result split(Context context, playerGame g){
        g.split();
        return Results.json().render(g);
    }

    public Result dealerPlay(Context context, dealerGame g){
        g.play();
        return Results.json().render(g);
    }

    public Result checkVal(Context context, @PathParam("dScore") int dScore,@PathParam("pScore") int pScore,@PathParam("spScore") int spScore,playerGame g){
        g.checkWinner(dScore,pScore,spScore);
        return Results.json().render(g);
    }

    /*public Result gameGet(){
        Game g = new Game();
        g.buildDeck();
        g.shuffle();
        g.deal();
        return Results.json().render(g);
    }

    public Result hit(Context context, Game g){
        if(context.getRequestPath().contains("hit")){
            g.hit();
        }
        return Results.json().render(g);
    }

    public Result split(Context context, @PathParam("columnFrom") int colFrom, @PathParam("columnTo") int colTo, Game g){
        if(context.getRequestPath().contains("split")){
            g.split(card);
        }
        return Results.json().render(g);
    }

    public Result stay(Context context, Game g){
        if(context.getRequestPath().contains("stay")){
            g.stay();
        }
        return Results.json().render(g);
    }*/
    
    public Result helloWorldJson() {
        
        SimplePojo simplePojo = new SimplePojo();
        simplePojo.content = "Hello World! Hello Json!";

        return Results.json().render(simplePojo);

    }
    
    public static class SimplePojo {

        public String content;
        
    }
}
