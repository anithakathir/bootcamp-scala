package bootcamp.remotecontrol

case class SkyCast(minChannel: Int, maxChannel: Int, currentChannel: Int, previousChannel: Int, blocked: List[Int],minClicks: Int) {

  def estimateMinClicks(next: Int): SkyCast = {
    val (current, clicks) =
      List(
        directClicks(currentChannel, next),
        getNumOfClicks(navigateUp)(currentChannel,next),
        getNumOfClicks(navigateDown)(currentChannel, next),
        getNumOfClicks(navigateUp)(previousChannel,next),
        getNumOfClicks(navigateDown)(previousChannel,next)
      ).minBy(_._2)
    SkyCast(minChannel, maxChannel, currentChannel = next, previousChannel = current, blocked, minClicks = minClicks + clicks)
  }

  def directClicks(currentChannel: Int, nextChannel: Int) ={
    (currentChannel,nextChannel.toString.length)
  }

  def navigateDown(currentChannel: Int, nextChannel: Int) ={
    if ( currentChannel <= nextChannel )
      List.range( currentChannel-1, minChannel-1, -1) ++ List.range(maxChannel,nextChannel-1,-1)
    else
      List.range(currentChannel-1,nextChannel-1,-1)
  }

  def navigateUp(currentChannel: Int, nextChannel: Int) ={
    if ( currentChannel <= nextChannel )
      List.range(currentChannel+1,nextChannel+1)
    else
      List.range(currentChannel+1,maxChannel+1) ++ List.range(minChannel,nextChannel+1)
  }

  def getNumOfClicks(sequence: (Int,Int) => List[Int])(currentChannel : Int,nextChannel: Int) ={
    val channelSequence: List[Int] = sequence(currentChannel, nextChannel)
    if(currentChannel == nextChannel)
      (currentChannel,0)
    channelSequence.foldLeft((previousChannel, 0)) {
      case ((blockedChannel, clicks), current) =>
        if (blocked.contains(current)) (blockedChannel, clicks)
        else (current, clicks + 1)
    }
  }

}