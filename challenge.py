def find_indexes(numberList, target):
  dict = {} # An empty dictionary is created to store the numbers and their indexes.
  for i, num in enumerate(numberList): # Use 'enumerate' to get index 'i' and value 'num' for each element in the list.
    comp = target - num
    if comp in dict: # The comp is checked to see if it already exists in the dictionary.
      return [dict[comp], i] # If found, it means that we have found a pair of numbers that add up to the target.
    dict[num] = i # If the comp is not found, we store the number and its index in the dictionary.

# Ejemplo
numberList = [12, 11, 6, 10, 4, 3, 25]
target = 37
print(find_indexes(numberList, target))  # Salida: [0, 1]
