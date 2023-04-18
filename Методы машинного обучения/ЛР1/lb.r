N = 120
RES <- c(T,F)
Kosos <- round(runif(N, 200, 900)) * 10^-3
Kpi <- round(runif(N, 200, 900)) * 10^-3
Kmsk <- round(runif(N, 200, 900)) * 10^-3
Kmi <- round(runif(N, 200, 900)) * 10^-3
frame = data.frame(RES, Kosos, Kpi, Kmsk, Kmi)
print(frame)

frame = data.frame(RES, Kosos, Kpi, Kmsk, Kmi)
print(frame)
