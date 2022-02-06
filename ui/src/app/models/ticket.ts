import { User, UserDTO } from './user';
import { Note } from './note';

export class Ticket {
  ticketId: number;
  title: string;
  description: string;
  ticketStatus: string;
  notes: Note[];
  createdAt: Date;
  client: UserDTO;
  employee: UserDTO;
}

export class TicketDTO {
  title: string;
  description: string;
  ticketStatus: string;
  client: number;
  employee: number;
}
