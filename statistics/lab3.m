nr_bune = 0;

for i=1:1000
  incercarex = unifrnd(0,1);
  incercarey = unifrnd(0,1);
  dist = sqrt((incercarex - 0.5)^2+(incercarey-0.5)^2);
  if(dist < 0.5)
    nr_bune = nr_bune + 1;
  endif
endfor
  
nr_bune
prob = nr_bune/1000


%2

A = randi(9,1,2)
B = randi(9,1,2)
C = randi(9,1,2)
D = randi(9,1,2)



hold on   
line(C,D) 

%plot(A);
%plot(B);

plot(A(1),A(2),'bo')
plot(B(1),B(2),'bo')

paranteza1 = (A(2)-C(2))/(D(2)-C(2))-(A(1)-C(1))/(D(1)-C(1));
paranteza2 = (B(2)-C(2))/(D(2)-C(2))-(B(1)-C(1))/(D(1)-C(1));

rez = paranteza1*paranteza2

if(rez>0)
  display("Sunt pe aceeasi parte")
endif