N = 30
Nrow = 1:N 
Name <- c("John","Kile","Emma","Oleg","Kate","Tolya","Max","Ann","Jim","Mary","John","Kile","Emma","Oleg","Kate","Tolya","Max","Ann","Jim","Mary","John","Kile","Emma","Oleg","Kate","Tolya","Max","Ann","Jim","Mary")
BirthYear = round(runif(N, 1974, 1993)) 
EmployYear = round(BirthYear+17, 2014)
Salary = ifelse(BirthYear < 1989 , (log(2015-EmployYear)+1)*7000, (log2(2015-EmployYear)+1)*7000)

EyeColor = EyeColor <- c("1","4","1","0","1","2","0","1","2","3","0","1","4","0","3","4","0","1","2","3","4","1","3","0","4","2","4","1","2","0")
ScinColor = ScinColor <- c("4","3","1","1","1","1","2","1","1","4","4","2","1","1","4","4","2","1","1","3","1","2","3","1","4","1","3","2","1","1")
BloodType = round(runif(N, 1, 4)) 
HairColor = HairColor <- c("5","9","3","8","2","1","3","1","4","3","1","5","1","1","4","5","2","3","1","9","3","7","1","3","6","4","9","3","1","4")

frame = data.frame(Nrow, Name, BirthYear, EmployYear, EyeColor, Salary , ScinColor, BloodType, HairColor)


coun = 3
Mrow = 1:coun
Group = c(1, 2, 3)  # 1 - en, 2 - ch - 3 de 
Eng_min = c(1.30,1.14,2.03)
Chin_min = c(2.80,1.14,3.43)
Ger_min = c(0.20,1.64,1.03)
Eng_max = c(3.30,3.54,4.03)
Chin_max = c(4.00,2.14,4.03)
Ger_max = c(3.10,3.14,4.03)

frame1 = data.frame(Mrow, Group, Eng_min, Chin_min, Ger_min, Eng_max, Chin_max, Ger_max)
ramFoT = frame1 
#library(kohonen) 
#library(RSNNS) 
#library(class) 
#library(gmodels) 
#library(modeest) 
#library(nnet) 
library(e1071) 
#ramFoT$Group 
ramFo2 = frame1
#ramFo2
#ramFo2 <- cbind(ramFo2, Group)
#model <- svm(ramFo2$, data = ramFo2, kernel = "linear")
#ramFoT$Group 
#print(model) 
#summary(model)
x <- subset(ramFo2[3:8]) 
y <- ramFo2$Group
model <- svm(x, y) 
print(model)
#summary(model)
pred <- predict(model, x) 
pred
#table(pred, y)
