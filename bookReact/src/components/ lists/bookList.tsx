import { List, Datagrid, TextField, EditButton } from "react-admin";

export const BookList = () => (
  <List>
    <Datagrid rowClick="show">
      <TextField source="id" />
      <TextField source="title" />
      <TextField source="author" />
      <TextField source="category" />
      <EditButton label="Edit" />
    </Datagrid>
  </List>
);
