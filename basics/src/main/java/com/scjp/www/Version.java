package com.scjp.www;

import java.util.Objects;

public class Version implements Comparable<Version> {

    private int x;
    private int y;
    private int z;
    private String snapshot;
    private String version;

    public Version() {
        throw new IllegalArgumentException("'version' must not be null");
    }

    public Version(String version) {
        this.version = version;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.snapshot = "";
        this.parseVersion(this.version);
    }

    public void parseVersion(String version) throws IllegalArgumentException {
        if (Objects.isNull(version)) {
            throw new IllegalArgumentException("'version' must not be null");
        }
        if(version.matches("\\d+(\\.\\d+){0,2}(-SNAPSHOT)?")) {
            if(version.contains("-SNAPSHOT")) {
                this.snapshot = "SNAPSHOT";
            }
        } else {
            throw new IllegalArgumentException("'version' must march: 'major.minor.patch(-SNAPSHOT)'!");
        }
    }


    public boolean isSnapshot() { return this.snapshot.equals("SNAPSHOT");}



    @Override
    public int compareTo(Version o) {
        if (Objects.isNull(o)) throw new IllegalArgumentException("'other' must not be null!");
        return 0;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Version version01 = (Version) o;
        return this.x == version01.x && this.y == version01.y && 
            Objects.equals(this.snapshot, version01.snapshot) && 
            Objects.equals(this.version, version01.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y,z,snapshot,version);
    }

    @Override
    public String toString() {
        return "Version{" +
        "x =" + x +
        ", y =" + y +
        ", z =" + z +
        ", snapshot='" + snapshot + "\'" +
        ", version='" + version + "\'" +
        "}";
    }
    
}
