import { Injectable, OnModuleInit } from '@nestjs/common';
import { CreateProductDto } from './dto/create-product.dto';
import { UpdateProductDto } from './dto/update-product.dto';
import { PrismaClient } from 'generated/prisma';

@Injectable()
export class ProductService extends PrismaClient implements OnModuleInit {
  async onModuleInit() {
    await this.$connect();
  }
  create(createProductDto: CreateProductDto) {
    return this.product.create({
      data: createProductDto
    });
  }

  findAll() {
    return this.product.findMany({
      orderBy:{
        createdAt: 'desc'
      }
    });
  }

  findOne() {
    return this.product.findFirst();
  }

  update(id: string, updateProductDto: UpdateProductDto) {
    return this.product.update({
        where: {id},
        data: updateProductDto
      })
  }

  remove(id: string) {
    return this.product.delete({where: {id}});
  }
}
