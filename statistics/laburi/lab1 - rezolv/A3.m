% Zwei Würfel werden 100 mal geworfen; wie oft taucht das Paar (1,1) auf?
clear
X=100
Wurfe=randi(6,X,2);
for(i=1:X)
  lovituri(i)=((Wurfe(i,1)==1)&&(Wurfe(i,2)==1));
endfor

sum(lovituri)

