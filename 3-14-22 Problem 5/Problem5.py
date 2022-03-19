#Looked up solution b/c \_/(*.*)\_/
#https://galaiko.rocks/posts/dcp/problem-5/
#Given
def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair

#Returns first digit
def car(f):
    def left(a, b):
        return a
    return f(left)

#Returns last digit
def cdr(f):
    def right(a, b):
        return b
    return f(right)


def main():
    test = cons(3,4)
    print(car(test))
    print(cdr(test))


if __name__ == '__main__':
    main()
