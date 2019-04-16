package pojos;
import javax.persistence.*;

@Entity
@Table(name="supplied_parts")
public class Part {
	private Integer id;
	private String name,description;
	private double price;
	private Vendor supplier;
	public Part() {
		// TODO Auto-generated constructor stub
	}
	public Part(String name, String description, double price, Vendor supplier) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.supplier = supplier;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=20)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(columnDefinition="double(7,1)")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@ManyToOne
	@JoinColumn(name="v_id")
	public Vendor getSupplier() {
		return supplier;
	}
	public void setSupplier(Vendor supplier) {
		this.supplier = supplier;
	}
	@Override
	public String toString() {
		return "Part [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", supplier="
				+ supplier + "]";
	}
	

}
