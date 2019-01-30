clear all
close all
figure
hold on
x = poissrnd(2,1,500);
% 1
varianz = var(x)

% 2
empirisch = sum(x==0)/500
theoretisch = poisscdf(0,2)

% 3
xx = min(x):0.01:max(x);
plot(xx,poisscdf(xx, 2), 'r.'); % theoretische Verteilungsfunktion

v=sort(x);
tt=min(x):0.01:max(x);
j=0;
Frep=zeros(1,length(tt));
for t=min(x):0.01:max(x)
j=j+1;
Frep(j)=sum(v<=t)/length(x); % empirische Verteilungsfunktion
end
plot(tt,Frep,'b.');

% 4
u = unique(x);
figure
hold on
hist(x,u); % hist abs. Haufigkeit

[nh,yh] = hist(x,u);
figure
subplot(2,1,1);
hold on
bar(yh,nh/sum(nh)); % hist rel. Haufigkeit

figure
hold on
i = 0:1:8;
yi = poisscdf(i,2);
bar(i,yi); % theoretische Verteliungsfunktion

figure
hold on
i = 0:1:8;
yi = poisspdf(i,2);
bar(i,yi); % theoretische Haufigkeit (theoretische Dichtefunktion)

% a2.
n = 64;
xn = 994;
sn = 25.6;
mo = 1000;
alpha = 0.05;
% ta = tinv(alpha, n-1);
ta = tinv(0.05,63)
% t = (xn - mo) / (sn / sqrt(n-1))
t = ((xn - mo) * sqrt(64) )/ sn
if t > ta
  disp('H0');
else
  disp('H1');
endif

% a3.
n = 10;
p = 0.3;
N = 1000;
% x = binornd(n,p,1,1000)
x = binornd(10,0.3,1,1000);
p3 = (sum(x < 7) - sum(x <= 3))/1000
e3 = mean(x) % empirisches E(x) (media aritm)
y = binopdf(4, 10, 0.3) + binopdf(5, 10, 0.3) + binopdf(6, 10, 0.3) % theor E(X) 
% ex = sum(binopdf(0:1:10, 10, 0.3).* [0:1:6]);

% a4.
m = 1000;
n = 500;
p = 0.46;
ct = 0;
for i = 1:m
  x = floor(rand(1, n) + p); % bernoulli
  if sum(x) > 235
    ct = ct + 1;
  endif
endfor
rez4 = ct/m

% a5.
x = normrnd(60, 5, 1, 1000);
p = sum(x > 55) / 1000
ptheorie = 1 - normcdf(55, 60, 5)

% a6.
pa = 0.6;
pb = 0.4;
n = 1000;
cca = 0;
for i = 1:n
  cta = 0;
  ctb = 0;
  while cta != 3 && ctb != 3
    c = floor(rand() + pa);
    if c == 1
      cta = cta + 1;
    else
      ctb = ctb + 1;
    endif
  endwhile
  if cta == 3 
    cca = cca + 1;
  endif
endfor
p6 = cca/n