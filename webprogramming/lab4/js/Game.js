class Game{
    currentInstance;
    player;
    pastScores = {
        'Player' : 0,
        'Computer' : 0
    };
    constructor (player){
        this.currentInstance = new Tictactoe();
        this.player = player;
    }

    newGame(){
        var winner = this.currentInstance.winner;
        if(winner!=null) {
            if (winner === this.player) {
                this.pastScores['Player'] += 1;
            } else {
                this.pastScores['Computer'] += 1;
            }
        }
        this.currentInstance = new Tictactoe();
    }

}