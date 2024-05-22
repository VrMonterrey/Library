import { Create, required, SimpleForm, TextInput } from "react-admin";

export const AuthorCreate = () => (
  <Create>
    <SimpleForm>
      <TextInput
        source="first_name"
        validate={[required()]}
        label="First Name"
      />
      <TextInput source="last_name" validate={[required()]} label="Last Name" />
    </SimpleForm>
  </Create>
);
