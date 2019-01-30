matrice = [
    [0,5,10,999],
    [5,0,4,11],
    [10,4,0,5],
    [999,11,5,0],
]



def get_min(list):
    minim = 0
    val = 99999999
    ind=-2
    for i in range(len(list)):
        if(list[i]<val and list[i]>minim and list[i]!=-1):
            val=list[i]
            ind=i

    return [val,ind]

def get_index(ind,matrice):
    maxind=len(matrice[0])
    ct=0
    while not ind<maxind:
        ind-=maxind
        ct+=1
    return [ct,ind]


def check_integrity_list(list):
    for elem in list:
        if elem == -1:
            return True
    return False

def check_integrity_matrix(matrix):
    for elem in matrix:
        if not check_integrity_list(elem):
            return False
    return True

def prim(matrice):
    checker=0
    cost_sum=0
    visited=[0]
    while checker<len(matrice)-1:
        for i in range(len(matrice)):
            minliste = []
            for q in range(i + 1):
                minliste += matrice[q]
            cost_minim =get_min(minliste)
            noduri = get_index(cost_minim[1],matrice)
            if(noduri[1] not in visited):
                print("Muchia "+str(noduri[0])+"-"+str(noduri[1])+"\n")
                checker+=1
                matrice[noduri[0]][noduri[1]]=-1
                matrice[noduri[1]][noduri[0]]=-1
                visited.append(noduri[1])
                cost_sum += cost_minim[0]
            print("pas "+str(i+1))
            print("checker: "+str(checker))
            for elem in matrice:
                print(elem)
            print(minliste)
            #if check_integrity_matrix(matrice):
             #   break
            if checker >len(matrice)-1:
              break
    print("Rezultat: "+str(cost_sum))



prim(matrice)
