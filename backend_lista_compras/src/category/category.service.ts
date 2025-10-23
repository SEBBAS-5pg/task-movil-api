import { Injectable, OnModuleInit } from '@nestjs/common';
import { CreateCategoryDto } from './dto/create-category.dto';
import { UpdateCategoryDto } from './dto/update-category.dto';
import { PrismaClient } from 'generated/prisma';

@Injectable()
export class CategoryService extends PrismaClient implements OnModuleInit{
  async onModuleInit() {
    await this.$connect();
  }

  create(createCategoryDto: CreateCategoryDto) {
    return this.category.create({
      data: createCategoryDto
    });
  }

  findAll() {
    return this.category.findMany({
      orderBy:{
        createdAt: 'desc'
      }
    });
  }

  findOne() {
    return this.category.findFirst();
  }
  
  update(id: string, updateCategoryDto: UpdateCategoryDto) {
    return this.category.update({
        where: {id},
        data: updateCategoryDto
      })
  }

  remove(id: string) {
    return this.category.delete({where: {id}});
  }
}
