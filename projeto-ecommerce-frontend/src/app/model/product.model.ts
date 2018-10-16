export class Product {
    id: string;
    name: string;
    price: number;
    pictureUrl: string;

    constructor(id: string, name: string, price: number, pictureUrl: string) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pictureUrl = pictureUrl;
    }
}
