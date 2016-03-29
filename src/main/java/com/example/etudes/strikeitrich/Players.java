package com.example.etudes.strikeitrich;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.*;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> values;
    private final Map<Player, State> states;

    public Players(List<Player> values) {
        this.values = values;
        states = new HashMap<>();
        initializeStates(values);
    }

    private void initializeStates(List<Player> values) {
        values.stream().forEach(x->states.put(x, new State(true)));
    }

    public Players standing() {
        final Set<Map.Entry<Player, State>> entries = states.entrySet();
        List<Player> standingPlayers = entries
                .stream()
                .filter(x -> x.getValue().isStanding())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return new Players(standingPlayers);
    }

    public boolean isNotEmpty() {
        return !values.isEmpty();
    }

    public void bankrupted(Player player) {
        this.states.put(player, new State(false));
    }

    public List<Player> values() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Players players = (Players) o;

        return new EqualsBuilder()
                .append(values, players.values)
                .append(states, players.states)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(values)
                .append(states)
                .toHashCode();
    }

    public boolean isSomeoneStanding() {
        return standing().isNotEmpty();
    }

    private class State {
        private final boolean standing;

        private State(boolean standing) {
            this.standing = standing;
        }

        protected boolean isStanding() {
            return standing;
        }
    }
}
