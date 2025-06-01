package blind75

/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
    
    val values = listOf(40,30,60)
    val weights = listOf(3,5,2)
    val bagWeight = 6
  
    val r = solve(values,weights,bagWeight,weights[0],0)
    println(r)
   
}

fun solve(values:List<Int>,weights:List<Int>,bagWeight:Int,currentWeight:Int,k:Int):Int{
    val i = k+1
    if(i>=weights.size) return 0
    if(currentWeight > bagWeight) return 0
    if(currentWeight == bagWeight) return values[i]
    
  
    val steal = values[k] + solve(values,weights,bagWeight,currentWeight+weights[i],i)
    val skip =  solve(values,weights,bagWeight,currentWeight+weights[i],i)
    
    return maxOf(steal,skip)
    
    
}