// Given a matrix that contains only the characters '0' and '1', find the biggest plus sign (+) formed by 1s in this matrix and return its size. Size, in this case, indicates the length of the plus sign's edges. In order to be a valid plus sign, the edges must be of equal length.
// For example, a plus sign with a size of k in matrix starts at cell (x, y). The plus sign's edges are (x - k, y), (x - k + 1, y), ..., (x + k, y) and (x, y - k), (x, y - k + 1), ..., (x, y + k), all with a length of k.

// Example For
//   matrix = ["0010010",
//             "1010101",
//             "1111111",
//             "0010000",
//             "0000000"]
// the output should be biggestPlus(matrix) = 1.

// Here, the biggest plus sign is centered at cell (2, 2) (0-based) and has a size of 1 since the downward facing edge is short.

int biggestPlus(String[] matrix) {
    // Check matrix
    if (matrix == null) {
        return 0;
    } else if (matrix.length == 0) {
        return 0;
    } else if (matrix[0].length() == 0) {
        return 0;
    }
    int row = matrix.length;
    int col = matrix[0].length();


    // Store the number of consecutive 1s of all directions from each cell
    int left[][] = new int[row][col];
    int right[][] = new int[row][col];
    int up[][] = new int[row][col];
    int down[][] = new int[row][col];

    // Fill the four arrays created while looping through the matrix
    for (int i=0; i< row; i++) {
        for (int j=0; j< col; j++) {
            int curr = Character.getNumericValue(matrix[i].charAt(j));
            if (curr == 1) {
                if (j != 0) {
                    right[i][j-1] = 1;
                    int temp_j = j-2;
                    while (temp_j >= 0 && right[i][temp_j] != 0) {
                        right[i][temp_j] += 1;
                        temp_j -= 1;
                    }
                }
                if (j < col -1) {
                    left[i][j+1] = left[i][j] + 1;
                }
                if (i != 0) {
                    down[i-1][j] = 1;
                    int temp_i = i-2;
                    while (temp_i >= 0 && down[temp_i][j] != 0) {
                        down[temp_i][j] += 1;
                        temp_i -= 1;
                    }
                }
                if (i < row -1) {
                    up[i+1][j] = up[i][j] + 1;
                }
            }
        }
    }

    // Find max plus length by looping through all cells and comparing their min side lengths
    int best_plus_length = 0;
    for (int i=0; i< row; i++) {
        for (int j=0; j< col; j++) {
            int plus_length = Math.min(left[i][j], Math.min(right[i][j], Math.min(up[i][j], down[i][j])));
            if (plus_length > best_plus_length) {
                best_plus_length = plus_length;
            }
        }
    }

    return best_plus_length;
}
