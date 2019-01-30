class Tictactoe {
    grid = [
        ['', '', ''],
        ['', '', ''],
        ['', '', ''],
    ];
    gameState = 'undecided';
    winner=null;
    makeMove(player, coord_x, coord_y) {
        if(this.gameState==='undecided') {
            this.grid[coord_y][coord_x] = player;
            if(this.checkGameState()){
                this.gameState = 'Won by'+player;
                this.winner = player;
            }
        }
    }

    tictacMove(player,coord_x,coord_y){
        this.makeMove(player,coord_x,coord_y);
        var computer='un de fined';
        if(player==='x'){
            computer = 'o';
        } else{
            computer = 'x';
        }
        var coords = this.getRandomCoords();
        this.makeMove(computer,coords[0],coords[1]);

    }

    getRandomCoords(){
        var safetyCounter = 0;
        var x;
        var y;
        while(true){
            x = getRandomInt(3);
            y = getRandomInt(3);
            if(this.grid[x][y]===''){
                return [x,y];
            }
            safetyCounter++;
            if(safetyCounter ===10){
                return null;
            }
        }
    }
    static getRandomInt(max) {
        return Math.floor(Math.random() * Math.floor(max));
    }

    checkGameState() {
        for (var i = 0; i < 3; i++) {
            for (var j = 0; i < 3; i++) {
                if (this.grid[i][j] !== '') {
                    if (i === 1 && j === 1) {
                        if (
                            (this.grid[i][j] === this.grid[i][j - 1] && this.grid[i][j] === this.grid[i][j + 1]) ||
                            (this.grid[i][j] === this.grid[i - 1][j] && this.grid[i][j] === this.grid[i + 1][j]) ||
                            (this.grid[i][j] === this.grid[i - 1][j - 1] && this.grid[i][j] === this.grid[i + 1][j + 1]) ||
                            (this.grid[i][j] === this.grid[i - 1][j + 1] && this.grid[i][j] === this.grid[i + 1][j - 1])
                        ) {
                            return true;
                        }
                    } else if (i === 0 && j < 2) {
                        if (
                            (this.grid[i][j] === this.grid[i][j + 1] && this.grid[i][j] === this.grid[i][j + 2]) ||
                            (this.grid[i][j] === this.grid[i + 1][j] && this.grid[i][j] === this.grid[i + 2][j])
                        ) {
                            return true;
                        }
                    } else if (i === 0 && j === 2) {
                        if (this.grid[i][j] === this.grid[i + 1][j] && this.grid[i][j] === this.grid[i + 2][j]) {
                            return true;
                        }
                    } else if (i === 2 && j === 0) {
                        if (this.grid[i][j] === this.grid[i][j + 1] && this.grid[i][j] === this.grid[i][j + 2]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}