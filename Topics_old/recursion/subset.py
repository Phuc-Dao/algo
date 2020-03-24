
class solution:
    def recursive_pset(self, input, pset, n, subArr):
        print(type(subArr))
        if(n == 0):
            subArr.insert(0, input[0])
            print(subArr)
            pset.append(subArr)
            return
       
        listWith = subArr.insert(0, input[n])
        pset.append([listWith])
        self.recursive_pset(input, pset, n - 1, subArr)
        self.recursive_pset(input, pset, n - 1, listWith)

    #Implamented starting from the nth index going backwards
    def pset(self, input):
        pset = [[]]
        self.recursive_pset(input, pset, len(input) - 1, [])
        return pset

sol = solution()
sol.pset([1,2,3])

    