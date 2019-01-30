import math



def main():
    n=0

    n=int(input("n: "))
    print("Elemente der Matrix: \n")
    a = [[0 for x in range(n)] for y in range(n)]

    a[0][2] = a[2][0] = 1
    a[1][4] = a[4][1] = 1
    a[3][2] = a[2][3] = 1
    a[2][4] = a[4][2] = 1
    a[5][4] = a[4][5] = 1
    for elem in a:
        print(elem)
    bincode = 0
    potenz = 0
    for i in range(0,n):
        for j in range(0,n):
            bincode = bincode + a[i][j] * math.pow(2,potenz)
            potenz+=1

    print("Das binare Code ist: " + str(bincode) + '\n')
    return

main()


