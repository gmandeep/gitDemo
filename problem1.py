import itertools

#method1
test_dict1 = {'gfg' : [5, 6, 7, 8], 'is' : [10, 11, 7, 5], 'best' : [6, 12, 10, 8], 'for' : [1, 2, 5]}
arr = test_dict1.values()
arr = list(arr)
new_list = []
for i in arr:
    for j in i :
        new_list.append(j)
new_list1  = []
for k in new_list:
    if k not in new_list1:
        new_list1.append(k)
new_list1.sort()
new_list1.reverse()
print(new_list1)

#method2
test_dict = {'gfg' : [5, 6, 7, 8], 'is' : [10, 11, 7, 5], 'best' : [6, 12, 10, 8], 'for' : [1, 2, 5]}
arr = test_dict.values()
arr = list(arr)
arr1 = list(itertools.chain.from_iterable(arr))
arr1 = set(arr1)
arr1 = list(arr1)
arr1.reverse()
print(arr1)