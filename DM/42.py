from random import randrange
from math import log, ceil

p = 2
q = 7
rng = 1 << ceil(log(q, 2))  # броски монеты
sm = 0
for i in range(10_000):
    n = randrange(rng)
    while n >= q:
        n = randrange(rng)
    if n < p:
        sm += 1
print(sm / i)
print(p / q)
