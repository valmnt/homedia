package fr.nexhub.player.domain.state

interface PlayerStateListener {
    fun on(state: PlayerState)
}