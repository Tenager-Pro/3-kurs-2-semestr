N = 30
Nrow = 1:N
Name = c("Liza","Kate","Sonya","Ann","Stepan","Jim","Mary","John","Kile","Emma",
  "Liza","Kate","Sonya","Ann","Stepan","Jim","Mary","John","Kile","Emma","Liza",
  "Kate","Sonya","Ann","Stepan","Jim","Mary","John","Kile","Emma")
BirthYear = round(runif(N, 1974, 1993))
EmployYear = round(BirthYear+17, 1993)
Salary = ifelse(BirthYear > 1989 , (log(2015-EmployYear)+1)*7000, (log10(2015-EmployYear)+1)*7000)
EyeColor = EyeColor <- c("0","1","2","0","1","2","0","1","2","2","0","1", "2","0","1","2","0","1","2","2","0","1","2","0","1","2","0","1","2","2")
ScinColor = ScinColor <- c("1","2","1","1","1","1","2","1","1","1","1","2","1","1","1","1","2","1","1","1","1","2","1","1","1","1","2","1","1","1")
BloodType = round(runif(N, 1, 4))
HairColor = HairColor <- c("1","2","3","2","2","1","3","1","1","3","1","3","1","1","3","3","2","3","1","1","3","2","1","3","3","1","2","1","1","3")
frame = data.frame(Nrow, Name, BirthYear, EmployYear, EyeColor, Salary ,
ScinColor, BloodType, HairColor)
countNeedSalary<- length(which(Salary > 16000))
frame$SocialVychet = frame$Salary * 0.13*(2019-EmployYear)
