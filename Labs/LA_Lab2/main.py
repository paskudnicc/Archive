import sys
from math import *

# sys.stdin = open('input.txt', 'r')
# sys.stdout = open('output.txt', 'w')


class Vector:
    def __init__(self, x, y, z):
        self.x = x
        self.y = y
        self.z = z

    def len(self):
        return (dot_product(self, self)) ** 0.5

    def mul_by_k(self, k):
        self.x *= k
        self.y *= k
        self.z *= k

    def __str__(self):
        return "(" + str(self.x) + ", " + str(self.y) + ", " + str(self.z) + ")"


def vector_sum(a, b):
    return Vector(a.x + b.x, a.y + b.y, a.z + b.z)


def vector_mul_by_k(a, k):
    return Vector(a.x * k, a.y * k, a.z * k)


def copy_vector(a):
    return Vector(a.x, a.y, a.z)


def dot_product(a, b):
    return a.x * b.x + a.y * b.y + a.z * b.z


def cross_product(a, b):
    return Vector(a.y * b.z - a.z * b.y, a.z * b.x - a.x * b.z, a.x * b.y - a.y * b.x)


def comb_product(a, b, c):
    return dot_product(a, cross_product(b, c))


def findcos(a, b):
    return dot_product(a, b)/(a.len() * b.len())


vx, vy = map(int, input().split())
ov = Vector(vx, vy, 0)
ax, ay = map(int, input().split())
va = Vector(ax, ay, 0)
mx, my = map(int, input().split())
vm = Vector(mx, my, 1)
prm = Vector(mx, my, 0)
wx, wy = map(int, input().split())
ow = Vector(wx, wy, 0)

vw = vector_sum(vector_mul_by_k(ov, -1), ow)

beta = degrees(acos(findcos(vw, va)))

if beta > 90:
    beta = beta - 90
else:
    beta = 90 - beta

if prm.len() != 0:
    gamma = degrees(acos(findcos(vm, prm)))
else:
    gamma = 90

if beta > 60 or gamma < 30:
    print(0)
elif comb_product(vw, va, Vector(0, 0, 1)) > 0:
    print(-1)
else:
    print(1)


print(round(beta, 2))
print(round(90 - gamma, 2))
print("Я стреляю сигареты раздаю бомжам")
