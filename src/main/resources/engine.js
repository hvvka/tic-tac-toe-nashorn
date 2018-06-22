/**
 * Tic Tac Toe
 *
 * Player:   o = -1
 * Opponent: x = 1
 */

var grid;
var intelligence;

var combos = [];
var board = [];
var undef;
var size = 100;

/**
 * Initializes game for specified grid and opponent's intelligence.
 *
 * @param _grid: board length and width
 * @param _intelligence: minimax recursion depth
 */
function startGame(_grid, _intelligence) {
    grid = _grid;
    intelligence = _intelligence;

    for (i = 0, c = [], d = []; i < grid; i++) {
        for (j = 0, a = [], b = []; j < grid; j++) {
            a.push(i * grid + j);
            b.push(j * grid + i);
        }
        combos.push(a, b);
        c.push(i * grid + i);
        d.push((grid - i - 1) * grid + i);
    }
    combos.push(c, d);
}

/**
 * @param move: last player (-1) move
 */
function makeMove(move) {
    var next;
    if (!board[move]) {
        draw(move, -1);  // o = -1, x = 1
        if (checkIfWon(0) < 0) {
            return "won";
        }

        next = search(0, 1, -size, size);

        if (next === undef) {
            return "tie";
        }
        draw(next);
        if (checkIfWon(0) > 0) {
            return "lost";
        }
    }

    // return Java.to(board, "int[]");
}

function draw(i, o) {
    board[i] = o || 1;
}

function getBoard() {
    return Java.to(board, "int[]");
}

/**
 *
 * @param depth givse higher values to quicker wins
 * @returns {number} winner if combo is present
 */
function checkIfWon(depth) {
    var j, x, o, k;
    for (var z in combos) {
        j = x = o = grid;
        while (j--) {
            k = combos[z][j];
            board[k] > 0 && x--;  //if
            board[k] < 0 && o--;  //if
        }

        // x won
        if (!x) {
            return size - depth;
        }
        // o won
        if (!o) {
            return depth - size;
        }
    }
}

/**
 * Negamax search with alpha-beta pruning.
 * http://en.wikipedia.org/wiki/Negamax
 * http://en.wikipedia.org/wiki/Alpha-beta_pruning
 *
 * @param depth: opponent's intelligence
 * @returns {*}
 */
function search(depth, player, alpha, beta) {
    var i = grid * grid;
    var min = -size;
    var max, value, next;

    // either player won
    if (value = checkIfWon(depth)) {
        return value * player;
    }

    // recursion cutoff
    if (intelligence > depth) {
        while (i--) {
            if (!board[i]) {
                board[i] = player;
                value = -search(depth + 1, -player, -beta, -alpha);
                board[i] = undef;

                if (max === undef || value > max) {
                    max = value;
                }

                if (value > alpha) {
                    alpha = value;
                }

                // prune branch
                if (alpha >= beta) {
                    return alpha;
                }

                // best odds for next move
                if (max > min) {
                    min = max;
                    next = i;
                }
            }
        }
    }
    return depth ? max || 0 : next;  // 0 is a tie
}
