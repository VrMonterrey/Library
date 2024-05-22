import {
  Create,
  ReferenceInput,
  required,
  SelectInput,
  SimpleForm,
  TextInput,
} from "react-admin";

export const BookCreate = () => (
  <Create>
    <SimpleForm>
      <TextInput
        source="first_name"
        validate={[required()]}
        label="First Name"
      />
      <ReferenceInput source="category" reference="categories">
        <SelectInput optionText="name" label={"Category"} />
      </ReferenceInput>
      <ReferenceInput source="author" reference="authors">
        <SelectInput
          optionText={(record) => `${record.first_name} ${record.last_name}`}
          label={"Author"}
        />
      </ReferenceInput>
    </SimpleForm>
  </Create>
);
