package app.context;

import java.util.UUID;

/**
 * Created by marc on 01/08/15.
 */
public class Entity {
    private UUID uuid;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;

        Entity entity = (Entity) o;

        return !(uuid != null ? !uuid.equals(entity.uuid) : entity.uuid != null);

    }

    @Override
    public int hashCode() {
        return uuid != null ? uuid.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "uuid=" + uuid +
                '}';
    }
}
