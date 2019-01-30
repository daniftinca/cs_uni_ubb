def cerc ( raza ) :
    pi = 3.14
    perimetru = 2*pi*raza
    aria = (pi*raza)**2
    print ( "Permietrul:" + str ( perimetru ) + "\n Aria:" + str ( aria ) )

cerc ( 5 )

def cmmdc ( a , b ) :
    while b :
        aux = a
        a = b
        b = aux % b
    return a


print ( cmmdc ( 4 , 10 ) )

def sumaNNumere ( ) :
    suma = 0
    nextNumber = int ( input( ) )
    while ( nextNumber != 0 ) :
        suma = suma + nextNumber
        nextNumber = int ( input( ) )
    return suma

print( sumaNNumere ( ) )