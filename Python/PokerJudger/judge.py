#!/usr/bin/env python
import sys


def get_hand_value(current_player):
    """Calculate how good the hand and return the value

    What each digit of the returned value represents:
        Digit 1: rank of the hand type defined below
        Digit 2-3: rank of the highest ranked card (rank of the pair in case of pair type)
        Digit 4-5: rank of the second highest ranked card (rank of the pair in case of pair type)
        Digit 6-7: rank of the third highest ranked card (rank of the single card in case of pair type)

    Value of hand type:
        Straight Flush: 6
        Three Of A Kind: 5
        Straight: 4
        Flush: 3
        Pair: 2
        High Card: 1
    """
    hand_value = ""

    # Digit 1 of hand type
    same_suit = False
    ranks = [current_player[1][0], current_player[2][0], current_player[3][0]]
    hand_rank_type = find_rank_type(ranks)
    if current_player[1][1] == current_player[2][1] == current_player[3][1]:
        same_suit = True
    if same_suit:
        if hand_rank_type == 4:
            hand_value += "6"
        elif hand_rank_type > 3:
            hand_value += str(hand_rank_type)
        else:
            hand_value += "3"
    else:
        hand_value += str(hand_rank_type)

    # Digit 2-3 of highest card/pair
    if hand_rank_type == 2:
        if ranks[0] == ranks[1] or ranks[0] == ranks[2]:
            pair_rank = ranks[0]
        else:
            pair_rank = ranks[1]
        # For pair, put in pair rank two times
        hand_value = hand_value + get_rank_value(pair_rank) + get_rank_value(pair_rank)
        ranks.remove(pair_rank)
        ranks.remove(pair_rank)
    else:
        highest_rank = max(ranks)
        hand_value += get_rank_value(highest_rank)
        ranks.remove(highest_rank)

    # Digit 4-5 of second highest rank (or rank of the pair in case of pair type)
    highest_rank = max(ranks)
    hand_value += get_rank_value(highest_rank)
    ranks.remove(highest_rank)

    # Digit 6-7 of third highest rank (or rank of the single card in case of pair type)
    if hand_rank_type != 2:
        hand_value += get_rank_value(ranks[0])

    return int(hand_value)


def get_rank_value(rank):
    """Given rank in integer, return the 2 digits string representation
        14 -> "14"
        2 -> "02"
    """
    if rank < 10:
        return "0" + str(rank)
    else:
        return str(rank)


def find_rank_type(ranks):
    """Find and return the rank type of the 3 ranks given

    Rank type results:
        1: no particularly interesting rank order, i.e. High Card
        2: pair rank
        4: straight
        5: three of a kind
    """
    ranks.sort()
    if ranks[0] == ranks[1] == ranks[2]:
        return 5
    elif ranks[1] == ranks[2] or ranks[0] == ranks[1] or ranks[0] == ranks[2]:
        return 2
    elif (ranks[0] + 1) == ranks[1] and (ranks[1] + 1) == ranks[2]:
        return 4
    elif 14 in ranks and 2 in ranks and 3 in ranks:
        return 4
    else:
        return 1


# Storing all players' info, each element in the list is a tuple storing player id and the hand value for the player calculated from get_hand_value
players = []
number_of_players = sys.stdin.readline().rstrip('\n')

for x in range(int(number_of_players)):
    current_player = sys.stdin.readline().rstrip('\n').split(" ")

    # Parse the input into simpler formats for later comparisons
    current_player[0] = int(current_player[0])
    for i in range(1,4):
        if current_player[i][0] == "A":
            rank = 14
        elif current_player[i][0] == "T":
            rank = 10
        elif current_player[i][0] == "J":
            rank = 11
        elif current_player[i][0] == "Q":
            rank = 12
        elif current_player[i][0] == "K":
            rank = 13
        else:
            rank = int(current_player[i][0])
        current_player[i] = (rank, current_player[i][1])

    players.append((int(current_player[0]), get_hand_value(current_player)))

winners = []
max = 0
for i in range(len(players)):
    if players[i][1] > max:
        winners.clear()
        winners.append(players[i][0])
        max = players[i][1]
    elif players[i][1] == max:
        winners.append(players[i][0])

winners.sort()
output = str(winners[0])
for i in range(1, len(winners)):
    output = output + " " + str(winners[i])

print (output)
