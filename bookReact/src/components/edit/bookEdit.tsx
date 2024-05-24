import {
  Edit,
  ReferenceInput,
  required,
  SelectInput,
  SimpleForm,
  TextInput,
} from "react-admin";

export const BookEdit = () => {
  return (
    <Edit>
      <SimpleForm>
        <TextInput source="title" validate={[required()]} label="Title" />
        <ReferenceInput source="category" reference="categories">
          <SelectInput optionText="name" label="Category" />
        </ReferenceInput>
        <ReferenceInput source="author" reference="authors">
          <SelectInput
            optionText={(record) => `${record.first_name} ${record.last_name}`}
            label="Author"
          />
        </ReferenceInput>
      </SimpleForm>
    </Edit>
  );
};
