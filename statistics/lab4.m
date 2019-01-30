
A = [0,0]
B = [4,0]
C = [4,4]
D = [0,4]

N = 50000

M=4*rand(2,N);



distA = sqrt((0-M(1,:)).^2+(0-M(2,:)).^2);
distB = sqrt((4-M(1,:)).^2+(0-M(2,:)).^2);
distC = sqrt((4-M(1,:)).^2+(4-M(2,:)).^2);
distD = sqrt((0-M(1,:)).^2+(4-M(2,:)).^2);

conditionA = (3<distA);
conditionB = (3<distB);
conditionC = (3<distC);
conditionD = (3<distD);

condition = conditionA + conditionB + conditionC + conditionD;

caz_fav = sum(condition==1)

probabilitate_a = caz_fav/N







#b
conditionA = (3>distA);
conditionB = (3>distB);
conditionC = (3>distC);
conditionD = (3>distD);

condition = conditionA + conditionB + conditionC + conditionD;

caz_fav_b = sum(condition == 4)

probabilitate_b = caz_fav_b/N



#C

distmA = sqrt((0-M(1,:)).^2+(2-M(2,:)).^2);
distmB = sqrt((4-M(1,:)).^2+(2-M(2,:)).^2);
distmC = sqrt((2-M(1,:)).^2+(4-M(2,:)).^2);
distmD = sqrt((2-M(1,:)).^2+(0-M(2,:)).^2);

conditionA = (2>distmA);
conditionB = (2>distmB);
conditionC = (2>distmC);
conditionD = (2>distmD);

condition = conditionA + conditionB + conditionC + conditionD;

caz_fav_c = sum(condition == 1)

probabilitate_c = caz_fav_c/N




x=fibo_rec(10)