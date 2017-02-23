package com.jedi.hackathons.domain;

/**
 * Created by deenan.vythilingam on 2017/02/23.
 */
public class Server {
    long id;
    long capacity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Server server = (Server) o;

        if (id != server.id) return false;
        return capacity == server.capacity;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (capacity ^ (capacity >>> 32));
        return result;
    }
}
