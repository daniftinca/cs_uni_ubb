def main():

    ind = 0
    x=0
    s=0
    n=float(input("n: "))
    v = [0 for x in range(int(50))]
    for i in range(0,int(n/2)+1):
        if(2**i)<=n:
            x=i
        else:
            break

    s = 2**x
    v[ind]=x #pe poz. 0 contine cel mai mare exp x pt care 2**x <=n
    ind+=1
    print(x)
    for i in range(x-1,-1,-1):
        if (s+2**i)<=n:
            v[ind]=i
            ind+=1
            s+=2**i
        elif s==n:
            break

    m=int(input("m:"))
    a = [[0 for x in range(m)] for y in range(m)]

    for p in range(ind-1,-1,-1):
        potenz = 0
        for i in range(0,m):
            for j in range(0,m):
                if potenz == v[p]:
                    a[i][j] = 1
                potenz+=1
    for elem in a:
        print (elem)
    return


main()