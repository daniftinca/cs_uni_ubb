
costPeLuna = 0.15/100
deinvestit = 1000
crestere= 10

profit = 0
costTotal= 0
for i in range(0,12):
    venit = (12/10/100)*deinvestit
    deinvestit +=venit

    cost = costPeLuna*(deinvestit+profit)
    profit += venit-cost
    deinvestit += venit-cost
    costTotal+=cost

print()
print("----------Cu profit lunar------------")
print("SumaTotala: " + str(deinvestit))
print("Profit: " + str(profit))
print("CostTotal: " + str(costTotal))


costPeLuna = 0.15/100
deinvestit = 1000
cresterePeAn= 10/100
nrAni = 30
costTotal = 0
adaugamLunar = 100
for j in range(nrAni):
    for i in range(0,12):
        if(adaugamLunar>0):
            deinvestit +=adaugamLunar
        deinvestit -= costPeLuna*deinvestit
        costTotal += costPeLuna*deinvestit
    deinvestit += cresterePeAn*deinvestit
    profitTotal = cresterePeAn*deinvestit

print("=======Cu Skepsis====")
print("Cost Total: "+str(costTotal))
print("Profit Total: "+str(profitTotal))
print("Suma totala: "+str(deinvestit))