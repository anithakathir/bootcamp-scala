package bootcamp.remotecontrol

import bootcamp.remotecontrol.SkyCast


object RemoteControl {
  def findMinClicks(minChannel: Int, maxChannel: Int, blocked: List[Int], toView: List[Int]): Int = {
    val initialState: SkyCast = SkyCast(minChannel, maxChannel, toView.head, toView.head, blocked, toView.head.toString.length)

    toView.foldLeft(initialState){ (currentState,nextState) => currentState.estimateMinClicks(nextState)}.minClicks

  }
}
