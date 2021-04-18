package strategy;

public class User {
    private String name;
    private String phone;
    private String email;

    public User(String name, String phone, String email){
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public User(User request) {
        name = request.name;
        phone = request.phone;
        email = request.email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    public String toString(){
        String str = "Client's name: " + this.name
                + "\nClient's phone: " + this.phone
                + "\nClient's email" + this.email;
        return str;
    }

    public boolean equals(User other){
        if (name.equals(other.name) && phone.equals(other.phone)
                && email.equals(other.email))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
